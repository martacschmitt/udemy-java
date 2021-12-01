package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalPaymentService;

public class Exercicio {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		
		Contract contract = new Contract(number, date, value);
		
		System.out.print("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		ContractService contractService = new ContractService(numberOfInstallments, new PaypalPaymentService());
		contractService.processContract(contract);
		
		System.out.println("Installments:");
		List<Installment> installments = contract.getInstallments();
		for (Installment installment : installments) {
			System.out.println(sdf.format(installment.getDueDate()) + " - " + String.format("%.2f", installment.getAmount()));
		}
		
		sc.close();
		
	}
	
}
