package br.com.ciadeideias.smartenem.parse;


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

            Elements novoDoc = doc.getElementsByClass("item");
            int length2 = novoDoc.size();

            for (int i = 0; i < length2; i++){
                listaElem.add(novoDoc.get(i).getElementsByClass("item"));
            }

            int length = listaElem.size();

            for (int i = 0; i < length; i++){
                RSSItem item = new RSSItem();
                String imagem, titulo, link, resumo, local, data, texto, img;

                titulo  = listaElem.get(i).select(".titulo").text().toString();
                item.setTitulo(titulo);
                resumo  = listaElem.get(i).select(".resumo").text().toString();
                item.setResumo(resumo);
                link    = listaElem.get(i).select(".link").attr("href").toString();
                item.setLink(link);
                local   = listaElem.get(i).select(".local").text().toString();
                item.setLocal(local);
                data    = listaElem.get(i).select(".datas").text().toString();
                item.setData(data);
                texto   = listaElem.get(i).select(".conteudo").text().toString();
                item.setTexto(texto);

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
