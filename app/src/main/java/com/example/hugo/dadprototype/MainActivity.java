package com.example.hugo.dadprototype;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/* Need code to add fragments to back stack, and pop each stack when back button is pressed, close app if no fragment open */
public class MainActivity extends ActionBarActivity {
    public  FragmentManager fragmanager;
    public FragmentTransaction ft;
    private String[] menuitems;
    private DrawerLayout Drawer;
    private ListView Dropdown;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmanager = getFragmentManager();
        ft = fragmanager.beginTransaction();
        setContentView(R.layout.activity_main);
        size = fragmanager.getBackStackEntryCount();
        // intantiate the string array as options for drop down menu
        menuitems = getResources().getStringArray(R.array.menuarray);
        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Dropdown = (ListView) findViewById(R.id.left_drawer);
       //setsup the drop down menu

        Dropdown.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuitems));

        Dropdown.setOnItemClickListener(new MenuItemClickListener());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onBackPressed(){
        getFragmentManager().popBackStack();
       /* if(getFragmentManager().getBackStackEntryCount()==0){
            getFragmentManager().popBackStack();


        }
        else {
            super.onBackPressed();
        }*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Custom class for menu item Onclick listeners
    public class MenuItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id){
         FrameLayout FragFrame = (FrameLayout) findViewById(R.id.contentDisplay);

         switch (position){

             case 0:
                  // Default homepage
                // Fragment fragment = new HomeFrag();
                // FragmentManager m = getFragmentManager();
               //  m.beginTransaction().replace(R.id.contentDisplay,fragment).commit();
                 break;


             case 1:

                 //Fragment fragment1 = new FavoritesFrag();
               //  FragmentManager m = getFragmentManager();
               //  m.beginTransaction().replace(R.id.contentDisplay,fragment1).commit();
                 break;

             case 2:
                 Fragment fragment2 = new ServicesFrag();

                 FragFrame.removeAllViews();

               // ft.addToBackStack("stack2");

                // .replace(R.id.contentDisplay, fragment2).commit();
                 fragmanager.beginTransaction().replace(R.id.contentDisplay, fragment2).addToBackStack("a").commit();
                 break;

             case 3:
                 Fragment fragment3 = new MaintainanceFrag();

                 FragFrame.removeAllViews();
               //  ft.addToBackStack("stack");

               //  ft.replace(R.id.contentDisplay, fragment3).commit();
                 fragmanager.beginTransaction().replace(R.id.contentDisplay, fragment3).addToBackStack("b").commit();
                 break;

             case 4:
                /* Fragment fragment4 = new CouponsFrag();
                 FragmentManager m4 = getFragmentManager();
                 m4.beginTransaction().replace(R.id.contentDisplay,fragment4).commit();*/
                 break;


             case 5:

             /* Fragment fragment5 = new SettingsFrag();
              FragmentManager m5 = getFragmentManager();
              m5.beginTransaction().replace(R.id.contentDisplay,fragment5).commit();*/
              break;}
            Dropdown.setItemChecked(position, true);
            setTitle(menuitems[position]);


            Drawer.closeDrawer(Dropdown);


        }






}}
