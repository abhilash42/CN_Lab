package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManager */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C00461();
    FragmentState[] f169a;
    int[] f170b;
    BackStackState[] f171c;

    /* compiled from: FragmentManager */
    static class C00461 implements Creator<FragmentManagerState> {
        C00461() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m199a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m200a(i);
        }

        public FragmentManagerState m199a(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] m200a(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f169a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f170b = parcel.createIntArray();
        this.f171c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f169a, i);
        parcel.writeIntArray(this.f170b);
        parcel.writeTypedArray(this.f171c, i);
    }
}
