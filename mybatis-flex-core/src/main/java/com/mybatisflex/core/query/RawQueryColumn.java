/*
 *  Copyright (c) 2022-2023, Mybatis-Flex (fuhai999@gmail.com).
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  <p>
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mybatisflex.core.query;


import com.mybatisflex.core.dialect.IDialect;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义字符串列，用于扩展
 */
public class RawQueryColumn extends QueryColumn implements HasParamsColumn {

    protected String content;
    protected Object[] params;


    public RawQueryColumn(Object content, Object... params) {
        this.content = String.valueOf(content);
        this.params = params;
    }

    @Override
    String toConditionSql(List<QueryTable> queryTables, IDialect dialect) {
        return content;
    }

    @Override
    String toSelectSql(List<QueryTable> queryTables, IDialect dialect) {
        return content + WrapperUtil.buildColumnAlias(alias, dialect);
    }

    @Override
    public String toString() {
        return "RawQueryColumn{" +
            "content='" + content + '\'' +
            ", params='" + Arrays.toString(params) + '\'' +
            '}';
    }

    @Override
    public RawQueryColumn clone() {
        return (RawQueryColumn) super.clone();
    }

    @Override
    public Object[] getParamValues() {
        return params;
    }

}
