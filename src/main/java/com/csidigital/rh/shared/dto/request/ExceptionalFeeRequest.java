package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.Currency;
import com.csidigital.rh.shared.enumeration.FeeType;
import lombok.Data;

@Data
public class ExceptionalFeeRequest {
        private FeeType feeType;
        private String shortDescription;
        private Long amount;
        private Currency currency;
        private String name;
        private Long contractId;

}
