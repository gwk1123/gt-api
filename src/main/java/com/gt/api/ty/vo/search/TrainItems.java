package com.gt.api.ty.vo.search;

import lombok.Data;

@Data
public class TrainItems {

        private int TrainID;
        private String TrainName;
        private String TrainShortName;
        private boolean Bookable;
        private boolean OnlineDisplay;
        private boolean OfflineDisplay;
        private int TrainTypeID;
        private String TrainTypeName;
        private String TrainTypeShortName;
        private int StartStationID;
        private String StartStationName;
        private int EndStationID;
        private String EndStationName;
        private String StartTime;
        private String EndTime;
        private int TotalDistance;
        private int TotalTakeDays;
        private boolean IsDirect;
        private int UseTime;
        private String PreSaleTime;
        private boolean IsStartStation;
        private boolean IsEndStation;
        private int PreSaleDay;
        private boolean IsSaleStop;
        private String NoteRemark;
        private String IsSupportCard;
        private TicketResult TicketResult;
        private boolean IsCanHB;
}
