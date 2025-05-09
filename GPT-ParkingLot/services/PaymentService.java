package services;

// import java.sql.Date;
import java.util.Date;

import enums.PaymentStatus;
import models.Ticket;

public class PaymentService {

    public double calculateFee(Ticket ticket) {
        long duration = (new Date().getTime() - ticket.getEntryDate().getTime()) / 1000 / 60;
        return duration * 0.5;
    }

    public PaymentStatus pay(Ticket ticket) {
        double fee = calculateFee(ticket);
        System.out.print("Paid: " + fee);
        return PaymentStatus.SUCCESS;
    }

}
