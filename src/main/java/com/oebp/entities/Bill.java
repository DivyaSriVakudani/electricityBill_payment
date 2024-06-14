
package com.oebp.entities;




import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

 

@Entity
public class Bill {

 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long billId;

    @NotNull(message="cannot be null")
    private LocalDate billDate;

    @NotNull(message="cannot be null")
    private LocalDate billDueDate;


   
    private int unitsConsumed;

    private int billAmount;
    
    @OneToOne
    private ElecReading elecreading;
    
     

    public Long getBillId() {
        return billId;
    }

 

    public void setBillId(Long billId) {
        this.billId = billId;
    }

 

    public LocalDate getBillDate() {
        return billDate;
    }

 

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

 

    public LocalDate getBillDueDate() {
        return billDueDate;
    }

 

    public void setBillDueDate(LocalDate billDueDate) {
        this.billDueDate = billDueDate;
    }

 

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

 

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

 

    public int getBillAmount() {
        return billAmount;
    }

 

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }



	public ElecReading getElecreading() {
		return elecreading;
	}



	public void setElecreading(ElecReading elecreading) {
		this.elecreading = elecreading;
	}


}