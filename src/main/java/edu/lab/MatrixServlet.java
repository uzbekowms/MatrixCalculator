package edu.lab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/matrix")
public class MatrixServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> aNums = parse(req.getParameterValues("numA"));
        List<Integer> bNums = parse(req.getParameterValues("numB"));
        String operation = req.getParameter("operation");

        List<Integer> results = doOperation(operation, aNums, bNums);

        req.setAttribute("items", results);

        req.getRequestDispatcher("/results.jsp").forward(req, resp);
    }

    private List<Integer> doOperation(String operation, List<Integer> aNums, List<Integer> bNums) {
        return switch (operation) {
            case "add" -> matrixAdd(aNums, bNums);
            case "sub" -> matrixSub(aNums, bNums);
            case "mul" -> matrixMul(aNums, bNums);
            default -> throw new RuntimeException("Invalid operation");
        };
    }

    private List<Integer> matrixMul(List<Integer> aNums, List<Integer> bNums) {
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

    private List<Integer> matrixSub(List<Integer> aNums, List<Integer> bNums) {
        List<Integer> results = new ArrayList<>(aNums.size());
        for (int i = 0; i < aNums.size(); i++) {
            results.add(aNums.get(i) - bNums.get(i));
        }
        return results;
    }

    private List<Integer> matrixAdd(List<Integer> aNums, List<Integer> bNums) {
        List<Integer> results = new ArrayList<>(aNums.size());
        for (int i = 0; i < aNums.size(); i++) {
            results.add(aNums.get(i) + bNums.get(i));
        }
        return results;
    }

    private List<Integer> parse(String[] nums) {
        return Arrays.stream(nums).map(Integer::parseInt).toList();
    }
}
