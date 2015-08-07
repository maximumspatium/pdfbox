/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pdfbox.tools.pdfdebugger.colorpane;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 * @author Khyrul Bashar.
 */

/**
 * This the table model for showing DeviceN color space which extends AbstractTableModel.
 */
public class DeviceNTableModel extends AbstractTableModel
{
    private static final String[] COLUMNNAMES = new String[] { "Colorant", "Maximum", "Minimum"};
    private final DeviceNColorant[] data;

    /**
     * Constructor
     * @param colorants array of DeviceNColorant
     */
    public DeviceNTableModel(DeviceNColorant[] colorants)
    {
        data = colorants;
    }

    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public int getColumnCount()
    {
        return COLUMNNAMES.length;
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        switch (column)
        {
            case 0:
                return data[row].getName();
            case 1:
                return data[row].getMaximum();
            case 2:
                return data[row].getMinimum();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return COLUMNNAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        switch (columnIndex)
        {
            case 0:
                return String.class;
            case 1:
            case 2:
                return Color.class;
            default:
                return null;
        }
    }
}