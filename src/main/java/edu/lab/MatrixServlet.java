package edu.lab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/matrix")
public class MatrixServlet extends HttpServlet {

    private final MatrixCalculator matrixCalculator = new MatrixCalculator();

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
            case "add" -> matrixCalculator.matrixAdd(aNums, bNums);
            case "sub" -> matrixCalculator.matrixSub(aNums, bNums);
            case "mul" -> matrixCalculator.matrixMul(aNums, bNums);
            default -> throw new RuntimeException("Invalid operation");
        };
    }

    private List<Integer> parse(String[] nums) {
        return Arrays.stream(nums).map(Integer::parseInt).toList();
    }
}
