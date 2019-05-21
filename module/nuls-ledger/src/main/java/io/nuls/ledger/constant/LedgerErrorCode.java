/*
 * MIT License
 *
 * Copyright (c) 2017-2018 nuls.io
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.nuls.ledger.constant;

import io.nuls.core.constant.CommonCodeConstanst;
import io.nuls.core.constant.ErrorCode;
import io.nuls.core.rpc.model.ModuleE;

/**
 * @author: LanJS
 */
public interface LedgerErrorCode extends CommonCodeConstanst {
    ErrorCode TX_IS_WRONG = ErrorCode.init(ModuleE.LG.abbr + "_0001");
    ErrorCode CHAIN_INIT_FAIL = ErrorCode.init(ModuleE.LG.abbr + "_0002");
    ErrorCode ORPHAN = ErrorCode.init(ModuleE.LG.abbr + "_1001");
    ErrorCode DOUBLE_EXPENSES = ErrorCode.init(ModuleE.LG.abbr + "_1002");
    ErrorCode TX_EXIST = ErrorCode.init(ModuleE.LG.abbr + "_1003");
    ErrorCode VALIDATE_FAIL = ErrorCode.init(ModuleE.LG.abbr + "_1010");
}