package ma.dounia.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ma.dounia.model.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Dounia
 */
@Repository
public class ArticleDaoImp implements ArticleDao
{
    Transaction Tx=null;
    
public  void create(Article art)
{ 
   
    try   
{   
      Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
    S.saveOrUpdate(art);
                   Tx.commit();
                   System.out.println("ADD OK");
          }
catch (Exception e) 
{
    Tx.rollback();
	e.printStackTrace();
        }
    
}

public  List<Article> getAll()
{   List<Article> articles = new ArrayList<Article>();
  
    try {
          Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
	articles = S.createQuery("from Article").list();
         } 
    catch (Exception e)
    {
       e.printStackTrace();
		}
        return articles;
}

public  Article getArticle(int idArticle) {
      
        Article art = null;
   try {
          Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
    
           art = (Article) S.get(Article.class, idArticle);
           System.out.println("Ok Found");
        } 
   catch (Exception e)
   {   
           e.printStackTrace();
           System.err.println("NOT FOUND");
    }		
        return art;
    }

public  void updateArticle(Article art) {
  try   {
   Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
    S.saveOrUpdate(art);
      System.out.println(" UPDATE OK");
   Tx.commit();
           }
  catch (Exception e) 
         {
                    Tx.rollback();
	e.printStackTrace();
          }
    }

    public  void deleteArticle(Article article) 
    {  
        try
        {
             Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
            Article art = (Article) S.get(Article.class, article.getCode());
            S.delete(art);
             Tx.commit();
             Tx.rollback();
        }
        catch (Exception e) 
        {
            Tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int id) {
      try
        {
             Session    S= HibernateUtil.getSessionFactory().openSession();
    Tx =S.beginTransaction(); 
            Article art = (Article) S.get(Article.class, id);
            S.delete(art);
             Tx.commit();
             
        }
        catch (Exception e) 
        {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    
}
