package br.com.ciadeideias.smartenem.parse;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 * Created by ClaudioSouza on 31/10/2016.
 */
public class RSSFeed implements Serializable {

    private static final long serialVersionUID = 1L;
    private int itemCount = 0;
    private List<RSSItem> itemList;

    RSSFeed(){
        itemList = new Vector<RSSItem>(0);
    }

    public void addItem(RSSItem item){
        itemList.add(item);
        itemCount++;
    }

    public RSSItem getItem(int location){
        return itemList.get(location);
    }

    public int getItemCount(){
        return itemCount;
    }
}
