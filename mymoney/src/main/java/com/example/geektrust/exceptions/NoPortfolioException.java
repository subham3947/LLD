package com.example.geektrust.exceptions;

public class NoPortfolioException extends Exception{

        public NoPortfolioException(){
            super("No Portfolio exists! Please allocate amount before running this operation.");
        }

}
