/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dounia.dao;

import java.util.ArrayList;
import java.util.List;
import ma.dounia.model.Article;

/**
 *
 * @author DOUNIA ABIELAALA
 */
public interface ArticleDao 
{
public  void create(Article art);
public  List<Article> getAll();
public  Article getArticle(int idArticle);
public  void updateArticle(Article art) ;
public  void deleteArticle(Article article) ;
public  void deleteArticle(int id) ;
   }
