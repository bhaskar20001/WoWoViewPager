package com.nightonke.wowoviewpagerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

public class SetEaseTypeActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView listView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ease_type);

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(new SetEaseTypeAdapter(this));
        listView.setOnItemClickListener(this);

        checkBox = (CheckBox)findViewById(R.id.checkbox);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (getIntent().getStringExtra("AnimationType")) {
            case "WoWoTranslationAnimation":
                intent = new Intent(this, WoWoTranslationAnimationActivity.class);
                break;
            case "WoWoScaleAnimation":
                intent = new Intent(this, WoWoScaleAnimationActivity.class);
                break;
            case "WoWoAlphaAnimation":
                intent = new Intent(this, WoWoAlphaAnimationActivity.class);
                break;
            case "WoWoShapeColorAnimation":
                intent = new Intent(this, WoWoShapeColorAnimationActivity.class);
                break;
            case "WoWoTextViewColorAnimation":
                intent = new Intent(this, WoWoTextViewColorAnimationActivity.class);
                break;
            case "WoWoBackgroundColorAnimation":
                intent = new Intent(this, WoWoBackgroundColorAnimationActivity.class);
                break;
            case "WoWoLayerListColorAnimation":
                intent = new Intent(this, WoWoLayerListColorAnimationActivity.class);
                break;
            case "WoWoStateListColorAnimation":
                intent = new Intent(this, WoWoStateListColorAnimationActivity.class);
                break;
            default: return;
        }
        switch (parent.getId()) {
            case R.id.listview:
                intent.putExtra("easeType", position);
                intent.putExtra("useSameEaseTypeBack", checkBox.isChecked());
                startActivity(intent);
                break;
        }
    }
}
