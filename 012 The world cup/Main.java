package com;

import java.util.Scanner;

class Node {
    private double rate;
    private int teamNumber;
    private Node rightChild;
    private Node leftChild;

    Node(double rate, int teamNumber) {
        this.rate = rate;
        this.teamNumber = teamNumber;
    }
    double getRate() {
        return rate;
    }
    void setRate(double rate) {
        this.rate = rate;
    }
    int getTeamNumber() {
        return teamNumber;
    }
    Node getRightChild() {
        return rightChild;
    }
    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    Node getLeftChild() {
        return leftChild;
    }
    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
}

public class Main {
    public static void main(String[] args) {
        double[][] rate = new double[16][16];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 16; ++i)
            for (int j = 0; j < 16; ++j)
                rate[i][j] = s.nextDouble();

        Node root = new Node(1.0, 0);
        int[] teamNumbers = new int[1];
        double[] result = new double[16];
        newRound(root, 16 / 2, teamNumbers, result, rate);

        for (int i = 0; i < 16; ++i) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }

    private static void newRound(Node root, int maxLayer, int[] teamNumbers, double[] result, double[][] rate) {
        buildTree(root, maxLayer, 0, teamNumbers, rate);
        calInit(root, maxLayer, result, rate);
    }

    private static void buildTree(Node n, int maxLayer, int layer, int[] teamNumbers, double[][] rate) {
        if (layer < maxLayer) {
            int temp = 2 * layer;
            int firstTeamNumber, secondTeamNumber;

            if (teamNumbers.length > 1) {
                firstTeamNumber = teamNumbers[temp];
                secondTeamNumber = teamNumbers[temp + 1];
            } else {
                firstTeamNumber = temp;
                secondTeamNumber = temp + 1;
            }

            n.setLeftChild(new Node(rate[firstTeamNumber][secondTeamNumber], firstTeamNumber));
            n.setRightChild(new Node(rate[secondTeamNumber][firstTeamNumber], secondTeamNumber));

            buildTree(n.getLeftChild(), maxLayer, layer + 1, teamNumbers, rate);
            buildTree(n.getRightChild(), maxLayer, layer + 1, teamNumbers, rate);
        }
    }

    private static void calInit(Node n, int maxLayer, double[] result, double[][] rate) {
        int[] teamNumbers = new int[maxLayer];
        calCore(n.getLeftChild(), maxLayer, 0, n.getRate(), teamNumbers, result, rate);
        calCore(n.getRightChild(), maxLayer, 0, n.getRate(), teamNumbers, result, rate);
    }

    private static void calCore(Node n, int maxLayer, int number, double winRate, int[] teamNumbers, double[] result, double[][] rate) {
        if (n.getLeftChild() != null) {
            winRate *= n.getRate();
            teamNumbers[number] = n.getTeamNumber();
            calCore(n.getLeftChild(), maxLayer, number + 1, winRate, teamNumbers, result, rate);
            calCore(n.getRightChild(), maxLayer, number + 1, winRate, teamNumbers, result, rate);
        } else {
            if (teamNumbers.length > 2) {
                n.setRate(n.getRate() * winRate);
                teamNumbers[number] = n.getTeamNumber();
                newRound(n, maxLayer / 2, teamNumbers, result, rate);
            } else {
                result[teamNumbers[0]] += n.getRate() * winRate * rate[teamNumbers[0]][n.getTeamNumber()];
                result[n.getTeamNumber()] += n.getRate() * winRate * rate[n.getTeamNumber()][teamNumbers[0]];
            }
        }
    }
}