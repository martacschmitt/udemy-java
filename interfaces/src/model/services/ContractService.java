package model.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private Integer numberOfInstallments;
	
	private PaymentService paymentService;
	
	public ContractService(Integer numberOfInstallments, PaymentService paymentService) {
		super();
		this.numberOfInstallments = numberOfInstallments;
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract) {
		int cont = 1;
		List<Installment> installments = new ArrayList<Installment>();
		while (cont <= numberOfInstallments) {
			LocalDate date = contract.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Date dueDate = Date.from(date.plusMonths(cont).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());			
		
			double value = paymentService.calculate(contract.getTotalValue() / numberOfInstallments, cont);
			
			Installment installment = new Installment(dueDate, value);
			installments.add(installment);
			cont++;
		}
		contract.setInstallments(installments);
	}
	
}