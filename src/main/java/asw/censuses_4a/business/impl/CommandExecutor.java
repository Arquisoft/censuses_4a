package asw.censuses_4a.business.impl;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import asw.censuses_4a.persistence.Jpa;

public class CommandExecutor {

	public Object execute(Command command){

		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();

		Object res = null;
		try {

			res = command.execute();

			trx.commit();

		} catch (RuntimeException bex) {

			if (trx.isActive())
				trx.rollback();
			throw bex;

		} finally {

			if (em.isOpen())
				em.close();

		}

		return res;

	}

}
