package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private Long transferId;
    private Long transferTypeId;
    private Long transferStatusId;
    private Long accountFrom;
    private Long accountTo;
    private BigDecimal amount;

    //private String transferType;
    //private String transferStatus;
    //private String userFrom;
    //private String userTo;


    public Transfer(Long transferId, Long transferTypeId, Long transferStatusId, Long accountFrom, Long accountTo, BigDecimal amount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    //Had a compile error in TransferService and it suggested this constructor...but i think it isn't necc, i need to do more in app and change makeTransAuth method
    public Transfer(AuthenticatedUser currentUser, BigDecimal amount) {
    }


    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(Long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public Long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(Long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

/*
    @Override
    public String toString() {
        return String.format("%d $ %.02f", transferId, amount);
    }

    @Override
    public String toString() {  //Should be in a child class Request(?), but that's not worth the time for this project
        return String.format("%-10d %7s %-15s $%.2f", id, "To:", recipientName, amount);
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Transfer From ID: " + getTransfer_from() + " in the amount of: $" + getAmount() + " Was sent to: " + getTransfer_to();
    }

	@Override
	public String toString() {
		return " Transfers: " + transfer_id + " Transfer Type Id:" + transfer_type_id
				+ " Transfer Status Id: " + transfer_status_id + " Account From: " + account_from + " Account to: "
				+ account_to + " Amount: "+ amount;
	}
		public String transferToString(Transfer transfer) {
		User user = new User();
		String transferType = "";
		String transferStatus = "";
		String transferString = "";
		if (transfer.getTransferTypeId() == 1) {
			transferType = "Request";
		} else transferType = "Send";
		if (transfer.getTransferStatusId() == 1) {
			transferStatus = "Pending";
		} else if (transfer.getTransferStatusId() == 2) {
			transferStatus = "Approved";
		} else transferStatus = "Rejected";

        transferString = "Id: " + transfer.getTransferId() + "\nType: " + transferType +
	            "\nStatus: " + transferStatus + "\nTo: " + transfer.getAccountTo() + "\nFrom: " + transfer.getAccountFrom()+
				"\nAmount: $" + transfer.getAmount();

	    return transferString;
	}

		@Override
	public String toString()
	{
		return "Transfer ID: " + this.getId() + ", Amount: $" + this.getAmount() + ", From: " + this.getUserFrom() + " To: " + this.getUserTo();
	}







*/