package edu.lab;

import java.util.ArrayList;
import java.util.List;

public class MatrixCalculator {


    public List<Integer> matrixMul(List<Integer> aNums, List<Integer> bNums) {
        List<Integer> resultMatrix = new ArrayList<>(aNums.size());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += aNums.get(i * 3 + k) * bNums.get(k * 3 + j);
                }
                resultMatrix.add(i * 3 + j, sum);
            }
        }

        return resultMatrix;
    }

    public List<Integer> matrixSub(List<Integer> aNums, List<Integer> bNums) {
        List<Integer> results = new ArrayList<>(aNums.size());
        for (int i = 0; i < aNums.size(); i++) {
            results.add(aNums.get(i) - bNums.get(i));
        }
        return results;
    }

    public List<Integer> matrixAdd(List<Integer> aNums, List<Integer> bNums) {
        List<Integer> results = new ArrayList<>(aNums.size());
        for (int i = 0; i < aNums.size(); i++) {
            results.add(aNums.get(i) + bNums.get(i));
        }
        return results;
    }

}
