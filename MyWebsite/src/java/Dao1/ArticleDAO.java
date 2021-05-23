/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;



import Model.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */



public class ArticleDAO extends DAO {

    public ArticleDAO() {
        super();
    }


    /**
     * get a article whose id is @key
     *
     * @param key
     * @return
     */
    public Article getarticleById(int key) {
    	Article article = new Article();
        String sql = "SELECT * FROM article WHERE id=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                article.setId(rs.getInt("id"));
                article.setName(rs.getString("name"));
                article.setImage(rs.getString("image"));
                article.setDes(rs.getString("des"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }

    /**
     * get all article from article
     *
     * @return
     */
    public ArrayList<Article> getAllarticle() {
        ArrayList<Article> result = new ArrayList<Article>();
        String sql = "SELECT * FROM article";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setName(rs.getString("name"));
                article.setImage(rs.getString("image"));
                article.setDes(rs.getString("des"));
                result.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add a new @article into the DB
     *
     * @param article
     */
    public void addarticle(Article article) {
        String sql = "INSERT INTO article(name, image, des) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, article.getName());
            ps.setString(2, article.getImage());
            ps.setString(3, article.getDes());

            ps.executeUpdate();

            //get id of the new inserted article
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                article.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @article
     *
     * @param article
     */
    public void editarticle(Article article) {
        String sql = "UPDATE article SET name=?, image =?, des=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, article.getName());
            ps.setString(2, article.getImage());
            ps.setString(3, article.getDes());
            ps.setInt(4, article.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the article whose id is @id
     *
     * @param id
     */
    public void deletearticle(int id) {
        String sql = "DELETE FROM article WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

