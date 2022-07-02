package com.mufan.leetcode.manager.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PythonCodeFileTest {

    @Test
    public void getFileName() {
        String code = "class ParkingSystem:\n" +
                "\n" +
                "    def __init__(self, big: int, medium: int, small: int):\n" +
                "\n" +
                "\n" +
                "    def addCar(self, carType: int) -> bool:\n" +
                "\n" +
                "\n" +
                "\n" +
                "# Your ParkingSystem object will be instantiated and called as such:\n" +
                "# obj = ParkingSystem(big, medium, small)\n" +
                "# param_1 = obj.addCar(carType)";
        Assert.assertEquals("ParkingSystem.py", new PythonCodeFile(code).getFileName());
        String code2 = "class Solution:\n" +
                "    def checkXMatrix(self, grid: List[List[int]]) -> bool:";
        Assert.assertEquals("Solution.py", new PythonCodeFile(code2).getFileName());
    }
}