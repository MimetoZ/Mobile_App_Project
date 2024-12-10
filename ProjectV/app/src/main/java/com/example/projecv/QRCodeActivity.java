package com.example.projecv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCodeActivity extends AppCompatActivity {

    private EditText inputText;
    private ImageView qrCodeImageView;
    private Button generateQRButton;
    private Button shareQRButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        inputText = findViewById(R.id.inputText);
        qrCodeImageView = findViewById(R.id.qrCodeImageView);
        generateQRButton = findViewById(R.id.generateQRCode);
        shareQRButton = findViewById(R.id.shareQRButton);

        Bundle b = getIntent().getExtras();
        String strInput = b.getString("VinetkaNumber") + "\t" +
                b.getString("EndDate");
        inputText.setText(strInput);

        generateQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQRCode();
            }
        });

        shareQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQRCode();
            }
        });

    }

    private void generateQRCode() {
        String text = inputText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Моля въведете текст", Toast.LENGTH_SHORT).show();
            return;
        }

        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        try {
            Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 400, 400);
            qrCodeImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void shareQRCode() {
        BitmapDrawable drawable = (BitmapDrawable) qrCodeImageView.getDrawable();
        if (drawable == null) {
            Toast.makeText(this, "Моля генерирайте QR код първо", Toast.LENGTH_SHORT).show();
            return;
        }

        Bitmap bitmap = drawable.getBitmap();
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "QRCode", null);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
        startActivity(Intent.createChooser(shareIntent, "Сподели QR код"));


    }
}