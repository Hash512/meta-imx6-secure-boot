# Copyright (C) 2012-2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP Linux mainline based kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on mainline kernel used by FSL Community BSP in order to \
provide support for some backported features and fixes, or because it was applied in linux-next \
and takes some time to become part of a stable version, or because it is not applicable for \
upstreaming."

include recipes-kernel/linux/linux-fslc.inc

PV = "4.8+git${SRCPV}"

SRCBRANCH = "4.8.x+fslc"
SRCREV = "532916d2c2cf8e596740c5c8e5c92d12d1a73bd8"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|vf)"
LINUX_VERSION ?= "4.8.15"

SRC_URI += " file://0001-crypto-caam-add-red-blobifier.patch \
			file://ima-ca-certificate.pem"

do_configure_prepend() {
	cp ${WORKDIR}/ima-ca-certificate.pem ${B}/
}