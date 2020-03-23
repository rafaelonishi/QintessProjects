package com.qintess.Desafio2;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	System.out.println("Inicio da execução");
        try {
        	Class.forName("org.h2.Driver");
        	
        	System.out.println("Conectou");
             } catch(Exception e) {
        	System.out.println("Driver nao encontrado"+e);
        }
        
        System.out.println("FIm de execução");
        
    }
}
