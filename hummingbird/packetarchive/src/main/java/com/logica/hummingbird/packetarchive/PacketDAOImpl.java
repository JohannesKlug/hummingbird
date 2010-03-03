package com.logica.hummingbird.packetarchive;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.logica.hummingbird.packetarchive.Packet;
import com.logica.hummingbird.packetarchive.PacketExample;
import com.logica.hummingbird.packetarchive.PacketKey;

import java.sql.SQLException;
import java.util.List;

public class PacketDAOImpl implements PacketDAO {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    private SqlMapClient sqlMapClient;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public PacketDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int countByExample(PacketExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("packet.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int deleteByExample(PacketExample example) throws SQLException {
        int rows = sqlMapClient.delete("packet.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int deleteByPrimaryKey(PacketKey key) throws SQLException {
        int rows = sqlMapClient.delete("packet.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public void insert(Packet record) throws SQLException {
        sqlMapClient.insert("packet.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public void insertSelective(Packet record) throws SQLException {
        sqlMapClient.insert("packet.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public List selectByExampleWithBLOBs(PacketExample example) throws SQLException {
        List list = sqlMapClient.queryForList("packet.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public List selectByExampleWithoutBLOBs(PacketExample example) throws SQLException {
        List list = sqlMapClient.queryForList("packet.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public Packet selectByPrimaryKey(PacketKey key) throws SQLException {
        Packet record = (Packet) sqlMapClient.queryForObject("packet.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int updateByExampleSelective(Packet record, PacketExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("packet.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int updateByExampleWithBLOBs(Packet record, PacketExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("packet.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int updateByExampleWithoutBLOBs(Packet record, PacketExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("packet.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int updateByPrimaryKeySelective(Packet record) throws SQLException {
        int rows = sqlMapClient.update("packet.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    public int updateByPrimaryKey(Packet record) throws SQLException {
        int rows = sqlMapClient.update("packet.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table packet
     *
     * @ibatorgenerated Mon Jan 11 12:06:07 CET 2010
     */
    private static class UpdateByExampleParms extends PacketExample {
        private Object record;

        public UpdateByExampleParms(Object record, PacketExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}