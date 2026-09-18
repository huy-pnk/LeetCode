package org.hard;

public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        int squareNumber = 0;
        boolean aliceTurn = true;
        boolean bobTurn = false;
        while(n > 0) {
            if(aliceTurn) {
                squareNumber = findTheBiggestSquareNumber(n);
                n = n - squareNumber;
            } else {
                n = n - squareNumber;
            }
            if(n<=0) break;
            if(aliceTurn) {bobTurn = true; aliceTurn = false;}
            else if(bobTurn) {aliceTurn = true; bobTurn = false;}
        }
        if(aliceTurn) return true;
        else return false;
    }

    public int findTheBiggestSquareNumber(int n) {
        for(int i=n;i>0;i--) {
            double sqrt = Math.sqrt(i);
            boolean isPerfectSquare = sqrt == Math.floor(sqrt);
            if(isPerfectSquare) return i;
        }
        return 1;
    }
}
