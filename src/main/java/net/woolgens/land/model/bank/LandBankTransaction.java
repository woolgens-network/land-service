package net.woolgens.land.model.bank;

import lombok.Data;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
public class LandBankTransaction {

    private double amount;
    private String issuer;
    private String type;
    private long timestamp;
}
