package com.market.hibernate.util;

import com.market.database.entity.Product;
import com.market.database.entity.User;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseOperations {
    
    //Veritabanına veri eklemek , silmek ve getirmek için gerekli fonksiyonların bulunduğu class.
    
    
    //User Operations
    //------------------------------------------------------------------------------------
    
    //Verilen verilere göre User tablosuna veri eklememizi sağlayan fonksiyon.
    public void addUser(String username, String password, String name, String lastName) {
        User instance = new User(username, password, name, lastName);
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (getUser(username) == null) {
                transaction = session.beginTransaction();
                session.save(instance);
                transaction.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Kullanıcı Mevcut!");
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    
    //Verilen kullanıcı parametresine göre User nesnesini döndüren fonksiyon.
    public User getUser(String username) {
        Transaction transaction = null;
        String foo = "FROM User WHERE username = '" + username + "'";
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<User> user = session.createQuery(foo).list();
            return user.get(0);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
        
    }

    //Verilen kullanıcı adı parametresine göre kullanıcı verilerini veri tabanından silen fonksiyon.
    public void deleteUser(String username) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object user = session.load(User.class, username);
            if (user != null) {
                session.delete(user);
                transaction.commit();
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }
    
    //Product Operations
    //---------------------------------------------------------------------------
    
    //Verilen ürün verilerine göre Product tablosuna veri ekleyen fonksiyon.
    public void addProduct(String productName, float price, int count) {
        Product instance = new Product(productName, price, count);
        Transaction transaction = null;
        if(getProductById(getIdByProductName(productName))==null){
            try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(instance);
                transaction.commit();

            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        else{
            updateProductCountById(getIdByProductName(productName), "coklu arttır", count);
        }
            
    }
    
    //Verilen id parametresine göre Product nesnesi döndüren fonksiyon.
    public Product getProductById(int id) {
        
        Transaction transaction = null;
        String foo = "FROM  Product WHERE id = " + id;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Product> product = session.createQuery(foo).list();
            return product.get(0);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
    
    //Verilen id parametresine göre ürünü Product tablosundan silen fonksiyon.
    public void deleteProductById(int id) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object product = session.load(Product.class, id);
            if (product != null) {
                session.delete(product);
                transaction.commit();
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }
    
    //Verilen id işlem ve adet parametresine göre ürünün miktarını güncelleyen fonksiyon.
    public boolean updateProductCountById(int id, String process,int count) {
        Transaction transaction = null;
        switch (process) {
            case "azalt":
                try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                if (getProductById(id).getCount() != 0) {
                    Product product = session.load(Product.class, id);
                    product.setCount(product.getCount() - 1);
                    session.update(product);
                    transaction.commit();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ürün depoda mevcut değil!");
                    return false;
                }
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                 }
                    e.printStackTrace();
                    return false;

                }
                
            case "arttır":
                try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                
                    Product product = session.load(Product.class, id);
                    product.setCount(product.getCount() + 1);
                    session.update(product);
                    transaction.commit();
                    return true;
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                }
                    e.printStackTrace();
                    return false;

                }
            case "coklu arttır":
                try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
                    transaction = session.beginTransaction();
                    Product product = session.load(Product.class, id);
                    product.setCount(product.getCount() + count);
                    session.update(product);
                    transaction.commit();
                    return true;
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                }
                    e.printStackTrace();
                    return false;

                }
            default:
                break;
        }
        return false;
    }
    
    //Verilen id parametresine göre ürünün idsini döndüren fonksiyon.
    public int getIdByProductName(String productName){
        Transaction transaction = null;
        String foo = "FROM  Product WHERE product_name = '" + productName + "'";
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Product> product = session.createQuery(foo).list();
            return product.get(0).getId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }
    
    //Veri tabanına kayıtlı bütün ürünleri Product listesi olarak döndüren fonksiyon.
    public List<Product> getProductsAsList(){
        Transaction transaction = null;
        String foo = "FROM  Product " ;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Product> product = session.createQuery(foo).list();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }
}
