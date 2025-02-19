/*******************************************************************************
 * Copyright (c) 2023 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package com.redhat.devtools.intellij.qute.lsp;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.redhat.devtools.intellij.lsp4ij.AbstractDocumentMatcher;
import com.redhat.devtools.intellij.lsp4ij.LSPIJUtils;
import com.redhat.devtools.intellij.qute.psi.utils.PsiQuteProjectUtils;

/**
 * Base class for Qute document matcher which checks that the file belongs to a Qute project.
 */
public class AbstractQuteDocumentMatcher extends AbstractDocumentMatcher {

    @Override
    public boolean match(VirtualFile file, Project fileProject) {
        Module module = LSPIJUtils.getModule(file, fileProject);
        return module != null && PsiQuteProjectUtils.hasQuteSupport(module);
    }
}