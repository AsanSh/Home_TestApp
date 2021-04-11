package com.wveika.taskapp.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.wveika.taskapp.R;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {


    ImageView imageView;
    private static final int GALLERY_REQUEST_CODE = 123;

    Uri imageUri;
    private ProfileViewModel profileViewModel;
    Button btnSelect;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        root.findViewById(R.id.btnSelect).setOnClickListener(v -> {
            selectImageFromGallery_btn();
        });
        root.findViewById(R.id.imageView).setOnClickListener(v -> {
            selectImageFromGallery_iv();
        });
        return root;
    }

    private void selectImageFromGallery_btn() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    private void selectImageFromGallery_iv() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}
