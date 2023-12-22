import numpy as np
from numpy import random

import argparse


def parse_cmd_arguments():
    parser = argparse.ArgumentParser()
    parser.add_argument("--train", help="location of the file contains clauses")
    parser.add_argument("--popsize", type=int)
    parser.add_argument("--elitism", type=int)
    parser.add_argument("--p", type=float)
    parser.add_argument("--K", type=float)
    parser.add_argument("--iter", type=int)
    parser.add_argument("--tournament", action="store_true")
    args = parser.parse_args()
    return args


def load_data(path):
    # we are using numpy to load data
    data = np.loadtxt(path, delimiter='\t')
    return data[:, :-1], data[:, -1]


def sigmoid(x):
    return 1.0 / (1.0 + np.exp(-x))


def median_squared_err(predicted, target):
    difference = predicted - target
    return np.mean(difference ** 2)


class Chromosome:
    def __init__(self, n):
        self.values = np.random.uniform(low=-4, high=4, size=n)
        self.fitness = 0

    def calculate_error(self, data, targets):
        output = np.sin(self.values[0] + self.values[1] * data[:, 0]) + self.values[2] * np.cos(
            data[:, 0] * (self.values[3] + data[:, 1])) / (1 + np.exp((data[:, 0] - self.values[4]) ** 2))
        return output, median_squared_err(output, targets)

    def set_values_from_parents(self, parent1, parent2):
        self.values = (parent1.values + parent2.values) / 2
        return

    def mutate(self, p, K):
        for i in range(len(self.values)):
            if np.random.random() < p:
                self.values[i] += np.random.normal(scale=K)
        return


def create_starting_population(popsize):
    population = []
    for i in range(popsize):
        population.append(Chromosome(5))
    return population


def evaluate_population(population, train_data, train_targets):
    fitness = np.array([])
    for chromosome in population:
        predictions, error = chromosome.calculate_error(train_data, train_targets)
        fitness = np.append(fitness, 1 / error)
    return fitness


def genetic_algorithm(train_data, train_targets, popsize, elitism, p, K,
                      iteration):
    starting_population = create_starting_population(popsize)
    fitness = evaluate_population(starting_population, train_data, train_targets)

    sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)

    best_individual = sorted_population[0][0]
    best_individual.fitness = sorted_population[0][1]

    for i in range(iteration):
        new_population = []

        sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)

        if sorted_population[0][1] > best_individual.fitness:
            best_individual = sorted_population[0][0]
            best_individual.fitness = sorted_population[0][1]

            print("Current best individual: ", best_individual.values, sep='')
            print("[Train error @", i + 1, "]: ", 1 / best_individual.fitness, sep='')

        for elite in range(elitism):
            new_population.append(sorted_population[elite][0])

        for j in range(popsize - elitism):
            parents = random.choice(starting_population, 2, p=fitness / fitness.sum())
            parent1 = parents[0]
            parent2 = parents[1]

            child = Chromosome(5)
            # todo ovdje je nesto cudno kod odabira roditelja
            child.set_values_from_parents(parent1, parent2)

            child.mutate(p, K)

            new_population.append(child)

        starting_population = new_population[:]
        fitness = evaluate_population(new_population, train_data, train_targets)

    #     return the best individual
    sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)
    best_individual = sorted_population[0][0]
    return best_individual


def genetic_algorithm_tournament(train_data, train_targets, popsize, p, K,
                                 iteration):
    starting_population = create_starting_population(popsize)
    fitness = evaluate_population(starting_population, train_data, train_targets)

    sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)

    best_individual = sorted_population[0][0]
    best_individual.fitness = sorted_population[0][1]

    for i in range(iteration):
        sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)

        if sorted_population[0][1] > best_individual.fitness:
            best_individual = sorted_population[0][0]
            best_individual.fitness = sorted_population[0][1]

            print("Current best individual: ", best_individual.values, sep='')
            print("[Train error @", i + 1, "]: ", 1 / best_individual.fitness, sep='')

        tournament = random.choice(starting_population, 3, p=fitness / fitness.sum())

        parents = sorted(tournament, key=lambda x: x.fitness, reverse=True)
        parent1 = parents[0]
        parent2 = parents[1]

        child = Chromosome(5)
        child.set_values_from_parents(parent1, parent2)

        child.mutate(p, K)

        starting_population.append(child)
        # we need to remove the worst out of the 3 selected parents
        starting_population.remove(parents[2])

        fitness = evaluate_population(starting_population, train_data, train_targets)

    sorted_population = sorted(zip(starting_population, fitness), key=lambda x: x[1], reverse=True)
    best_individual = sorted_population[0][0]
    return best_individual


def main():
    args = parse_cmd_arguments()

    train_data, train_targets = load_data(args.train)

    # --train /Users/kazokid/Documents/fer/diplomski/1SEM/MEKO/dz4/zad4-dataset1.txt --popsize 250 --p 0.05 --elitism 5 --K 1 --iter 1000
    # bestIndividual1 = genetic_algorithm(train_data, train_targets, args.popsize,
    #                                    args.elitism, args.p,
    #                                    args.K, args.iter)

    # --train /Users/kazokid/Documents/fer/diplomski/1SEM/MEKO/dz4/zad4-dataset1.txt --popsize 200 --p 0.1 --elitism 5 --K 1 --iter 3000 --tournament
    bestIndividual2 = genetic_algorithm_tournament(train_data, train_targets, args.popsize,
                                                   args.p,
                                                   args.K, args.iter)

    # print("Best individual (generation): ", bestIndividual1.values, sep='')
    # print("[Train error]: ", 1 / bestIndividual1.fitness, sep='')

    print("Best individual (tournament): ", bestIndividual2.values, sep='')
    print("[Train error]: ", 1 / bestIndividual2.fitness, sep='')


if __name__ == "__main__":
    main()
