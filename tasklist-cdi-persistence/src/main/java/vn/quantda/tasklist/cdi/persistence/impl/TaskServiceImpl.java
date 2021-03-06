package vn.quantda.tasklist.cdi.persistence.impl;

import java.util.Collection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import vn.quantda.tasklist.cdi.model.Task;
import vn.quantda.tasklist.cdi.model.TaskService;

@OsgiServiceProvider(classes= {TaskService.class})
@Properties({
	@Property(name="service.exported.interfaces", value="*")
})
@Named
@Transactional
public class TaskServiceImpl implements TaskService {

	@PersistenceContext(unitName="tasklist")
	EntityManager em;
	
	@Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Task getTask(Integer id) {
        return em.find(Task.class, id);
    }

    @Override
    public void addTask(Task task) {
        em.persist(task);
        em.flush();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Collection<Task> getTasks() {
        CriteriaQuery<Task> query = em.getCriteriaBuilder().createQuery(Task.class);
        return em.createQuery(query.select(query.from(Task.class))).getResultList();
    }

    @Override
    public void updateTask(Task task) {
        em.merge(task);
    }
    
    @Override
    public void deleteTask(Integer id) {
        em.remove(getTask(id));
    }


}
