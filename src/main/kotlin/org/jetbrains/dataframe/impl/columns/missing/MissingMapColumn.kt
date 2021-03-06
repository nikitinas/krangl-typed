package org.jetbrains.dataframe.impl.columns.missing

import org.jetbrains.dataframe.AnyCol
import org.jetbrains.dataframe.DataFrame
import org.jetbrains.dataframe.DataRow
import org.jetbrains.dataframe.columns.ColumnReference
import org.jetbrains.dataframe.columns.MapColumn

internal class MissingMapColumn<T> : MissingDataColumn<DataRow<T>>(), MapColumn<T> {

    override fun <R> get(column: ColumnReference<R>) = MissingValueColumn<R>()

    override fun <R> get(column: ColumnReference<DataRow<R>>) = MissingMapColumn<R>()

    override fun <R> get(column: ColumnReference<DataFrame<R>>) = MissingFrameColumn<R>()

    override val df: DataFrame<T>
        get() = throw UnsupportedOperationException()

    override fun tryGetColumn(columnName: String): AnyCol? {
        return null
    }

    override fun column(columnIndex: Int): AnyCol {
        return MissingValueColumn<Any?>()
    }

    override fun ncol(): Int = 0

    override fun get(index: Int) = throw UnsupportedOperationException()

    override fun get(columnName: String) = throw UnsupportedOperationException()

    override fun nrow(): Int = 0

    override fun columns(): List<AnyCol> = emptyList()

    override fun rows(): Iterable<DataRow<T>> = emptyList()

    override fun getColumnIndex(name: String) = -1

    override fun append(vararg values: Any?) = throw UnsupportedOperationException()

    override fun kind() = super.kind()

    override fun set(columnName: String, value: AnyCol) = throw UnsupportedOperationException()
}