package com.nonglam.baobaoshopadmin.ui.products;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.nonglam.baobaoshopadmin.API.APIServices;
import com.nonglam.baobaoshopadmin.Adapter.ProductAdapter;
import com.nonglam.baobaoshopadmin.ProductEditer;
import com.nonglam.baobaoshopadmin.databinding.FragmentProductsBinding;
import com.nonglam.baobaoshopadmin.model.GroupProduct;
import com.nonglam.baobaoshopadmin.model.Product;
import com.nonglam.baobaoshopadmin.static_data.DataSource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFragment extends Fragment {


    private FragmentProductsBinding binding;
    private ListView listView;
    private Button btnLoadMore;
    private ArrayList<Product> listProduct = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentProductsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = (ListView) binding.LVProducts;
        btnLoadMore = (Button) binding.LsProductLoadMore;


        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DataSource.nextPage++;

                APIServices.apiServices.getProducts(DataSource.nextPage,"Bearer "+ DataSource.token)
                        .enqueue(new Callback<GroupProduct>() {
                            @Override
                            public void onResponse(Call<GroupProduct> call, Response<GroupProduct> response) {

                                for ( Product product_item: response.body().getList()) {
                                    listProduct.add(product_item);
                                }

                                ProductAdapter arrayAdapter = new ProductAdapter(getActivity(),listProduct);
                                listView.setAdapter(arrayAdapter);
                                listView.setOnItemClickListener((adapterView, view, i, l) ->
                                        onClickItem(i)
                                );

                            }
                            @Override
                            public void onFailure(Call<GroupProduct> call, Throwable t) {
                                showAlert();
                            }
                        });

            }
        });
        // TODO Auto-generated method stub
        APIServices.apiServices.getProducts(1,"Bearer "+ DataSource.token)
        .enqueue(new Callback<GroupProduct>() {
            @Override
            public void onResponse(Call<GroupProduct> call, Response<GroupProduct> response) {

                for ( Product product_item: response.body().getList()) {
                    listProduct.add(product_item);
                }

                ProductAdapter arrayAdapter = new ProductAdapter(getActivity(),listProduct);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener((adapterView, view, i, l) ->
                        onClickItem(i)
                );

            }
            @Override
            public void onFailure(Call<GroupProduct> call, Throwable t) {
                showAlert();
            }
        });
        ;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showAlert(){
        new AlertDialog.Builder(getContext())
                .setTitle("Lỗi")
                .setMessage("Lỗi tải dữ liệu")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private void onClickItem(int i){
        //Toast.makeText(getContext()," hihihih123 " + i + " "+ listProduct.get(i).toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getContext(), ProductEditer.class);
        intent.putExtra("EXTRA_SESSION_ID", listProduct.get(i).toString());
        startActivity(intent);
    }


}