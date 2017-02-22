package pkgMain;

import org.apache.poi.ss.formula.functions.*;

import java.util.Scanner;

public class cMain {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many years do you plan to work?");
		double YearsToWork = sc.nextDouble();
		double NperPMT = (YearsToWork * 12);
		
		System.out.println("What is your expected % return on investment before retirement?");
		double InitRate = sc.nextDouble();
		while ((InitRate < 0) || (InitRate > 20))
		{
			System.out.println("Invalid entry. Please enter a value between 0 and 20.");
			InitRate = sc.nextDouble();
		}
		double RateBefore = (InitRate * 0.01);
		double RatePMT = (RateBefore / 12);
		
		System.out.println("How many years do you plan to draw from retirement?");
		double YearsRetired = sc.nextDouble();
		double NperPV = (YearsRetired * 12);
		
		System.out.println("What is your expected % return on investment after retirement?");
		InitRate = sc.nextDouble();
		while ((InitRate < 0) || (InitRate > 3))
		{
			System.out.println("Invalid entry. Please enter a value between 0 and 3.");
			InitRate = sc.nextDouble();
		}
		double RateAfter = (InitRate * 0.01);
		double RatePV = (RateAfter / 12);
		
		System.out.println("How much income (in dollars per month) do you require after retirement?");
		double RequiredIncome = sc.nextDouble();
		
		System.out.println("What is your expected Social Security Income (in dollars per month)?");
		double MonthlySSI = sc.nextDouble();
		
		double PayPerMonth = (MonthlySSI - RequiredIncome);
		
		double FinalPV = FindPV(RatePV, NperPV, PayPerMonth, 0.0, false);
		double FinalPMT = FindPMT(RatePMT, NperPMT, 0.0, FinalPV * -1, false);
		
		System.out.printf("What you need saved by retirement: " + "$%.2f \n", FinalPV);
		System.out.printf("What you need to save every month: " + "$%.2f \n", FinalPMT);
	}
	
	public static double FindPMT(double r, double n, double p, double f, boolean t)
	{
		return FinanceLib.pmt(r, n, p, f, t);
	}
	
	public static double FindFV(double r, double n, double y, double p, boolean t)
	{
		return FinanceLib.fv(r, n, y, p, t);
	}
	
	public static double FindPV(double r, double n, double y, double f, boolean t)
	{
		return FinanceLib.pv(r, n, y, f, t);
	}

}
