package forallstudio.mobilephone.allmobile;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import forallstudio.mobilephone.BR;
import forallstudio.mobilephone.data.Mobile;

public class MobileListViewModel extends BaseObservable {

    private List<Mobile> mobiles = new ArrayList<>();

    @Bindable
    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
        notifyPropertyChanged(BR.mobiles);
    }

}