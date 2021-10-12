package com.gt.api.ty.vo.search;

import lombok.Data;

@Data
public class TicketItems {

        private String TicketID;
        private boolean Bookable;
        private String SeatTypeID;
        private String SeatTypeName;
        private String Price;
        private String ShowPrice;
        private String Inventory;

}
