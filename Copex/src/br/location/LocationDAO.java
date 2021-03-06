/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.location;

import br.certificate.Certificate;
import br.person.Person;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class LocationDAO extends GenericDAO<Location>{

    public LocationDAO() {
        super(Location.class);
    }
    
    public List<Location> listPerPerson(Person p, boolean entregue) {
        List<Location> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Location.class)
                    .add(Restrictions.eq("person", p)).
                    add(Restrictions.eq("entregue", entregue)).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;
    }
    
    //verifica se já foi cadastrado o certificado
    public List<Location> verify(Person p, Certificate c) {
        List<Location> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Location.class)
                    .add(Restrictions.eq("person", p)).
                    add(Restrictions.eq("certificate", c)).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;
    }
    
    public List<Location> listPerCoautores(Person p, boolean entregue) {
        List<Location> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            Criteria crit = this.getSessao().createCriteria(Location.class);
            crit.createAlias("cooautores", "c");
            crit.add(Restrictions.eq("c.nome", p.getNome()));
            crit.add(Restrictions.eq("entregue", entregue));
            lista = crit.list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;
    }
    
    
    
}
