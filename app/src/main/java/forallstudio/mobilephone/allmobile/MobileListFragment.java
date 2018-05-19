package forallstudio.mobilephone.allmobile;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import forallstudio.mobilephone.R;
import forallstudio.mobilephone.data.Mobile;
import forallstudio.mobilephone.databinding.FragmentMobileListBinding;

public class MobileListFragment extends Fragment implements
        MobileListAdapter.MobileListAdapterListener {

    private FragmentMobileListBinding binding;
    private MobileListViewModel viewModel;

    public static MobileListFragment newInstance() {
        return new MobileListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new MobileListViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_mobile_list, container, false);
        initRecycleView();
        binding.setViewModel(viewModel);
        binding.setListener(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @BindingAdapter({"bind:items", "bind:listener"})
    public static void mobileListAdapter(RecyclerView view, List<Mobile> mobiles,
                                         MobileListAdapter.MobileListAdapterListener listener) {
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter instanceof MobileListAdapter) {
            ((MobileListAdapter) adapter).update(mobiles);
        } else {
            adapter = new MobileListAdapter(mobiles, listener);
            view.setAdapter(adapter);
        }
    }

    @Override
    public void onMobileClicked(Mobile mobile) {
        Toast.makeText(getContext(), "mobile clicked: " + mobile.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFavoriteClicked(Mobile mobile) {
        Toast.makeText(getContext(), "mobile favorite clicked: " + mobile.getName(), Toast.LENGTH_SHORT).show();
    }

    private void initRecycleView() {
        binding.listAllMobile.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
        );
    }

}