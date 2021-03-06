package com.itqf.erp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StoreoperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreoperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Integer value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Integer value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Integer value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Integer value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Integer value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Integer> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Integer> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Integer value1, Integer value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Integer value1, Integer value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidIsNull() {
            addCriterion("EMPUUID is null");
            return (Criteria) this;
        }

        public Criteria andEmpuuidIsNotNull() {
            addCriterion("EMPUUID is not null");
            return (Criteria) this;
        }

        public Criteria andEmpuuidEqualTo(Integer value) {
            addCriterion("EMPUUID =", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidNotEqualTo(Integer value) {
            addCriterion("EMPUUID <>", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidGreaterThan(Integer value) {
            addCriterion("EMPUUID >", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EMPUUID >=", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidLessThan(Integer value) {
            addCriterion("EMPUUID <", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidLessThanOrEqualTo(Integer value) {
            addCriterion("EMPUUID <=", value, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidIn(List<Integer> values) {
            addCriterion("EMPUUID in", values, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidNotIn(List<Integer> values) {
            addCriterion("EMPUUID not in", values, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidBetween(Integer value1, Integer value2) {
            addCriterion("EMPUUID between", value1, value2, "empuuid");
            return (Criteria) this;
        }

        public Criteria andEmpuuidNotBetween(Integer value1, Integer value2) {
            addCriterion("EMPUUID not between", value1, value2, "empuuid");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNull() {
            addCriterion("OPERTIME is null");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNotNull() {
            addCriterion("OPERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpertimeEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME =", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME <>", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERTIME >", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME >=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThan(Date value) {
            addCriterionForJDBCDate("OPERTIME <", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME <=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeIn(List<Date> values) {
            addCriterionForJDBCDate("OPERTIME in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERTIME not in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERTIME between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERTIME not between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andStoreuuidIsNull() {
            addCriterion("STOREUUID is null");
            return (Criteria) this;
        }

        public Criteria andStoreuuidIsNotNull() {
            addCriterion("STOREUUID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreuuidEqualTo(Integer value) {
            addCriterion("STOREUUID =", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotEqualTo(Integer value) {
            addCriterion("STOREUUID <>", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidGreaterThan(Integer value) {
            addCriterion("STOREUUID >", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("STOREUUID >=", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidLessThan(Integer value) {
            addCriterion("STOREUUID <", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidLessThanOrEqualTo(Integer value) {
            addCriterion("STOREUUID <=", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidIn(List<Integer> values) {
            addCriterion("STOREUUID in", values, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotIn(List<Integer> values) {
            addCriterion("STOREUUID not in", values, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidBetween(Integer value1, Integer value2) {
            addCriterion("STOREUUID between", value1, value2, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotBetween(Integer value1, Integer value2) {
            addCriterion("STOREUUID not between", value1, value2, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidIsNull() {
            addCriterion("GOODSUUID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidIsNotNull() {
            addCriterion("GOODSUUID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidEqualTo(Integer value) {
            addCriterion("GOODSUUID =", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotEqualTo(Integer value) {
            addCriterion("GOODSUUID <>", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidGreaterThan(Integer value) {
            addCriterion("GOODSUUID >", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSUUID >=", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidLessThan(Integer value) {
            addCriterion("GOODSUUID <", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSUUID <=", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidIn(List<Integer> values) {
            addCriterion("GOODSUUID in", values, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotIn(List<Integer> values) {
            addCriterion("GOODSUUID not in", values, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidBetween(Integer value1, Integer value2) {
            addCriterion("GOODSUUID between", value1, value2, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSUUID not between", value1, value2, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}