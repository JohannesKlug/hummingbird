package com.logica.hummingbird.parameterarchive;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.logica.hummingbird.parameterarchive.Parameter;
import com.logica.hummingbird.parameterarchive.ParameterExample;
import com.logica.hummingbird.parameterarchive.ParameterKey;

import java.sql.SQLException;
import java.util.List;

public class ParameterDAOImpl implements ParameterDAO {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    private SqlMapClient sqlMapClient;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public ParameterDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int countByExample(ParameterExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("parameter.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int deleteByExample(ParameterExample example) throws SQLException {
        int rows = sqlMapClient.delete("parameter.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int deleteByPrimaryKey(ParameterKey key) throws SQLException {
        int rows = sqlMapClient.delete("parameter.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public void insert(Parameter record) throws SQLException {
        sqlMapClient.insert("parameter.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public void insertSelective(Parameter record) throws SQLException {
        sqlMapClient.insert("parameter.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public List selectByExample(ParameterExample example) throws SQLException {
        List list = sqlMapClient.queryForList("parameter.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public Parameter selectByPrimaryKey(ParameterKey key) throws SQLException {
        Parameter record = (Parameter) sqlMapClient.queryForObject("parameter.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int updateByExampleSelective(Parameter record, ParameterExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("parameter.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int updateByExample(Parameter record, ParameterExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("parameter.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int updateByPrimaryKeySelective(Parameter record) throws SQLException {
        int rows = sqlMapClient.update("parameter.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    public int updateByPrimaryKey(Parameter record) throws SQLException {
        int rows = sqlMapClient.update("parameter.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table parameter
     *
     * @ibatorgenerated Tue Jan 12 00:04:48 CET 2010
     */
    private static class UpdateByExampleParms extends ParameterExample {
        private Object record;

        public UpdateByExampleParms(Object record, ParameterExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}