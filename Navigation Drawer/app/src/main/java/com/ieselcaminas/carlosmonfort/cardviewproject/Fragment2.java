package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;

import android.support.v4.util.Pair;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.id;

/**
 * Created by alu20472135l on 10/11/16.
 */

public class Fragment2 extends Fragment {

    public Fragment2() {
        // Required empty public constructor
    }
    ListView lstOpciones;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_fragment2, container, false);

        final Titular[] datos = new Titular[]{
                new Titular(R.drawable.whale,"Carlos Monfort", "1978"),
                new Titular(R.drawable.whale2,"Marta Pineda", "50"),
                new Titular(R.drawable.whale3,"The prodigius kid", "9999"),
                new Titular(R.drawable.whale4,"Anabel Ruiz", "0"),
                new Titular(R.drawable.whale5,"Robert Alain", "9998"),
                new Titular(R.drawable.whale6,"The prodigius baby", "9997"),
                new Titular(R.drawable.whale7,"Alejandro Galvez", "2000"),
                new Titular(R.drawable.whale8,"Alicia", "2500")};



          lstOpciones = (ListView)rootView.findViewById(R.id.listf2);
        final AdaptadorTitulares adaptador = new AdaptadorTitulares(getActivity(), datos);
        lstOpciones.setAdapter(adaptador);
        registerForContextMenu(lstOpciones);


        lstOpciones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
                            public boolean onItemLongClick (AdapterView parent, View view,int position,long id) {
                                ActionMode mActionMode = getActivity().startActionMode(modeCallBack);
                                mActionMode.setTag(position);
                                view.setSelected(true);
                                return true;
                            }
                        });

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                final View sharedtextview = v.findViewById(R.id.LblTitulo);
                Pair<View, String> p1 =  new Pair(sharedtextview,sharedtextview.getTransitionName());
                Titular item = datos[position];
                Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), p1).toBundle();
                intent.putExtra("NOM",item.getTitulo());
                intent.putExtra("IMAGE",item.getImage());
                getActivity().startActivity(intent, options);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }
    /* Menu flotante hace cosicas
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v,menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        if(v.getId() == R.id.listf2){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            inflater.inflate(R.menu.list_menu,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        Toast toast;
        switch (item.getItemId()){
            case R.id.editar:
                toast = Toast.makeText(getContext(), "Editado",Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.eliminar:
                toast = Toast.makeText(getContext(), "Eliminado",Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.compartir:
                toast = Toast.makeText(getContext(), "Compartido",Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    */

    private ActionMode.Callback modeCallBack = new ActionMode.Callback() {
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu){
                            return false;
                        }
                        public void onDestroyActionMode(ActionMode mode) {
                            mode =null;
                        }
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            mode.setTitle("Options");
                            mode.getMenuInflater().inflate(R.menu.menu_contex, menu);
                            return true;
                        }
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            int id = item.getItemId();
                            switch(id) {
                                case R.id.eliminar: {
                                    mode.finish();
                                    break;
                                }
                                case R.id.editar: {
                                    mode.finish();
                                    break;
                                }
                                case R.id.compartir: {
                                    mode.finish();
                                    break;
                                }
                                default:
                                    return false;
                            }
                            return false;
                        }
    };
}
