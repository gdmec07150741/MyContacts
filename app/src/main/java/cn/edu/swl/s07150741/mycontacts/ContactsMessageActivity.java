package cn.edu.swl.s07150741.mycontacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by asus on 2016/11/1.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private EditText nameEditText,mobileEditText,qqEditText,danweiEditText,addressEditText;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contancts_message);
        setTitle("添加联系人");
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        qqEditText = (EditText) findViewById(R.id.qq);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        addressEditText = (EditText) findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);

        nameEditText.setText("姓名："+user.getName());
        mobileEditText.setText("电话："+user.getMobile());
        qqEditText.setText("qq："+user.getQq());
        danweiEditText.setText("单位："+user.getDanwei());
        addressEditText.setText("地位："+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
