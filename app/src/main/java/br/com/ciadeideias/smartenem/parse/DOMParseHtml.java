package br.com.ciadeideias.smartenem.parse;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by ClaudioSouza on 31/10/2016.
 */
public class DOMParseHtml {

    private RSSFeed feed = new RSSFeed();

    public RSSFeed parseHtml(String html){

        try {
            Document doc = Jsoup.connect(html).get();
            doc.normalise();

            ArrayList<Elements> listaElem = new ArrayList<Elements>();

            Elements novoDoc = doc.select("li.media");
            int length2 = novoDoc.size();
            Log.d("claudio", "o doc recebido é: /n"+ novoDoc.html());

            for (int i = 0; i < length2; i++){
                listaElem.add(novoDoc.get(i).getElementsByClass("media"));
            }

            int length = listaElem.size();

            for (int i = 0; i < length; i++){
                RSSItem item = new RSSItem();
                String imagem, titulo, link, resumo, data, img;

                titulo  = listaElem.get(i).select("h5").text().toString();
                item.setTitulo(titulo);
                resumo  = listaElem.get(i).select("p").text().toString();
                item.setResumo(resumo);
                link    = listaElem.get(i).select("a").attr("href").toString();
                item.setLink(link);
                data    = listaElem.get(i).select("cite").text().toString();
                item.setData(data);
                img     = listaElem.get(i).select("img").attr("src").toString();
                if (!img.isEmpty()){
                    imagem = img;
                    item.setImagem(imagem);
                }else{
                    imagem = null;
                    item.setImagem(imagem);
                }

                feed.addItem(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return feed;
    }
}
