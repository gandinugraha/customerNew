package com.example.mrrobot.customernew.parcelable;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;




@AutoValue
public abstract class SalonCustomerParcelable implements Parcelable {

    public abstract String salonId();
    public abstract String salonName();
    public abstract String salonAddress();
    public abstract String salonManagerName();
    public abstract String salonManagerUser();
    public abstract String salonRating();
    public abstract String salonTotalReview();
    public abstract String salonTotalStylish();
    public abstract boolean salonSubscriptionStatus();
    public abstract String salonImageUrl();

//    public abstract String createdBy();
//    public abstract String updatedBy();
//    public abstract Date createdDate();
//    public abstract Date updatedDate();

    public static Builder builder() {
        return new AutoValue_SalonCustomerParcelable.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setSalonId(String value);
        public abstract Builder setSalonName(String value);
        public abstract Builder setSalonAddress(String value);
        public abstract Builder setSalonManagerName(String value);
        public abstract Builder setSalonManagerUser(String value);
        public abstract Builder setSalonRating(String value);
        public abstract Builder setSalonTotalReview(String value);
        public abstract Builder setSalonTotalStylish(String value);
        public abstract Builder setSalonSubscriptionStatus(boolean value);
        public abstract Builder setSalonImageUrl(String value);

//        public abstract Builder setcreatedBy(String value);
//        public abstract Builder setupdatedBy(String value);
//        public abstract Builder setcreatedDate(Date value);
//        public abstract Builder setupdatedDate(Date value);

        public abstract SalonCustomerParcelable build();
    }
    /*
    public static SalonCustomerParcelable create(String salonId, String summary, String description) {
            return new AutoValue_SalonCustomerParcelable(salonId, summary, description);
            }
            */
}
