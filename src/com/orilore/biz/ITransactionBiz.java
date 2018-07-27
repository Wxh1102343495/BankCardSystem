package com.orilore.biz;
import com.orilore.model.*;
import java.util.*;
public interface ITransactionBiz{
	public boolean addTransaction(Transaction transaction,Card card);
	public boolean removeTransaction(int id);
	public boolean modifyTransaction(Transaction transaction);
	public Transaction getTransaction(int id);
	public List<Transaction> findTransaction();
	public List<Transaction> findCardTransaction(int cid);
	public void close();
}