package com.nonglam.baobaoshopadmin.ui.products;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.nonglam.baobaoshopadmin.API.APIServices;
import com.nonglam.baobaoshopadmin.Adapter.ProductAdapter;
import com.nonglam.baobaoshopadmin.databinding.FragmentProductsBinding;
import com.nonglam.baobaoshopadmin.model.GroupProduct;
import com.nonglam.baobaoshopadmin.static_data.DataSource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFragment extends Fragment {

    private ProductsViewModel productsViewModel;
    private FragmentProductsBinding binding;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productsViewModel =
                new ViewModelProvider(this).get(ProductsViewModel.class);

        binding = FragmentProductsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // TODO Auto-generated method stub
        APIServices.apiServices.getProducts("Bearer "+ DataSource.token)
        .enqueue(new Callback<GroupProduct>() {
            @Override
            public void onResponse(Call<GroupProduct> call, Response<GroupProduct> response) {
                Log.d("XYZ",response.body().getListToString());
            }

            @Override
            public void onFailure(Call<GroupProduct> call, Throwable t) {
                Log.d("abc", "0943" + t.toString());
            }
        });
        ;


        listView = (ListView) binding.LVProducts;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");
        arrayList.add("android");
        arrayList.add("Kotllin");
        arrayList.add("great");
        arrayList.add("is");

        ProductAdapter arrayAdapter = new ProductAdapter(getActivity(),arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) ->

                Toast.makeText(getContext()," hihihih " + i + " "+ arrayList.get(i).toString(), Toast.LENGTH_LONG).show()

        );

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}