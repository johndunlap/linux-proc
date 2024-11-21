package org.voidzero.linux.proc;

/*-
 * #%L
 * linux-proc
 * %%
 * Copyright (C) 2023 - 2024 John Dunlap
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Unit tests for {@link CpuInfo}.
 */
public class CpuInfoTest {
    public static final List<String> SAMPLE_CPUINFO_OUTPUT = Arrays.asList(("processor\t: 0\n"
        + "vendor_id\t: GenuineIntel\n"
        + "cpu family\t: 6\n"
        + "model\t\t: 154\n"
        + "model name\t: 12th Gen Intel(R) Core(TM) i7-1255U\n"
        + "stepping\t: 4\n"
        + "microcode\t: 0x434\n"
        + "cpu MHz\t\t: 2859.078\n"
        + "cache size\t: 12288 KB\n"
        + "physical id\t: 0\n"
        + "siblings\t: 12\n"
        + "core id\t\t: 0\n"
        + "cpu cores\t: 10\n"
        + "apicid\t\t: 0\n"
        + "initial apicid\t: 0\n"
        + "fpu\t\t: yes\n"
        + "fpu_exception\t: yes\n"
        + "cpuid level\t: 32\n"
        + "wp\t\t: yes\n"
        + "flags\t\t: fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush dts acpi mmx fxsr"
        + " sse sse2 ss ht tm pbe syscall nx pdpe1gb rdtscp lm constant_tsc art arch_perfmon pebs bts rep_good nopl"
        + " xtopology nonstop_tsc cpuid aperfmperf tsc_known_freq pni pclmulqdq dtes64 monitor ds_cpl vmx smx est tm2"
        + " ssse3 sdbg fma cx16 xtpr pdcm pcid sse4_1 sse4_2 x2apic movbe popcnt tsc_deadline_timer aes xsave avx f16c"
        + " rdrand lahf_lm abm 3dnowprefetch cpuid_fault epb invpcid_single ssbd ibrs ibpb stibp ibrs_enhanced"
        + " tpr_shadow vnmi flexpriority ept vpid ept_ad fsgsbase tsc_adjust bmi1 avx2 smep bmi2 erms invpcid rdseed"
        + " adx smap clflushopt clwb intel_pt sha_ni xsaveopt xsavec xgetbv1 xsaves split_lock_detect avx_vnni dtherm"
        + " ida arat pln pts hwp hwp_notify hwp_act_window hwp_epp hwp_pkg_req hfi umip pku ospke waitpkg gfni vaes"
        + " vpclmulqdq rdpid movdiri movdir64b fsrm md_clear serialize arch_lbr ibt flush_l1d arch_capabilities\n"
        + "vmx flags\t: vnmi preemption_timer posted_intr invvpid ept_x_only ept_ad ept_1gb flexpriority apicv"
        + " tsc_offset vtpr mtf vapic ept vpid unrestricted_guest vapic_reg vid ple shadow_vmcs ept_mode_based_exec"
        + " tsc_scaling usr_wait_pause\n"
        + "bugs\t\t: spectre_v1 spectre_v2 spec_store_bypass swapgs\n"
        + "bogomips\t: 5222.40\n"
        + "clflush size\t: 64\n"
        + "cache_alignment\t: 64\n"
        + "address sizes\t: 39 bits physical, 48 bits virtual\n"
        + "power management:\n"
        + "\n"
        + "processor\t: 1\n"
        + "vendor_id\t: GenuineIntel\n"
        + "cpu family\t: 6\n"
        + "model\t\t: 154\n"
        + "model name\t: 12th Gen Intel(R) Core(TM) i7-1255U\n"
        + "stepping\t: 4\n"
        + "microcode\t: 0x434\n"
        + "cpu MHz\t\t: 2600.000\n"
        + "cache size\t: 12288 KB\n"
        + "physical id\t: 0\n"
        + "siblings\t: 12\n"
        + "core id\t\t: 0\n"
        + "cpu cores\t: 10\n"
        + "apicid\t\t: 1\n"
        + "initial apicid\t: 1\n"
        + "fpu\t\t: yes\n"
        + "fpu_exception\t: yes\n"
        + "cpuid level\t: 32\n"
        + "wp\t\t: yes\n"
        + "flags\t\t: fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush dts acpi mmx fxsr"
        + " sse sse2 ss ht tm pbe syscall nx pdpe1gb rdtscp lm constant_tsc art arch_perfmon pebs bts rep_good nopl"
        + " xtopology nonstop_tsc cpuid aperfmperf tsc_known_freq pni pclmulqdq dtes64 monitor ds_cpl vmx smx est tm2"
        + " ssse3 sdbg fma cx16 xtpr pdcm pcid sse4_1 sse4_2 x2apic movbe popcnt tsc_deadline_timer aes xsave avx f16c"
        + " rdrand lahf_lm abm 3dnowprefetch cpuid_fault epb invpcid_single ssbd ibrs ibpb stibp ibrs_enhanced"
        + " tpr_shadow vnmi flexpriority ept vpid ept_ad fsgsbase tsc_adjust bmi1 avx2 smep bmi2 erms invpcid rdseed"
        + " adx smap clflushopt clwb intel_pt sha_ni xsaveopt xsavec xgetbv1 xsaves split_lock_detect avx_vnni dtherm"
        + " ida arat pln pts hwp hwp_notify hwp_act_window hwp_epp hwp_pkg_req hfi umip pku ospke waitpkg gfni vaes"
        + " vpclmulqdq rdpid movdiri movdir64b fsrm md_clear serialize arch_lbr ibt flush_l1d arch_capabilities\n"
        + "vmx flags\t: vnmi preemption_timer posted_intr invvpid ept_x_only ept_ad ept_1gb flexpriority apicv"
        + " tsc_offset vtpr mtf vapic ept vpid unrestricted_guest vapic_reg vid ple shadow_vmcs ept_mode_based_exec"
        + " tsc_scaling usr_wait_pause\n"
        + "bugs\t\t: spectre_v1 spectre_v2 spec_store_bypass swapgs\n"
        + "bogomips\t: 5222.40\n"
        + "clflush size\t: 64\n"
        + "cache_alignment\t: 64\n"
        + "address sizes\t: 39 bits physical, 48 bits virtual\n"
        + "power management:\n").split("\n"));

    @Test
    public void testGetCpuCountMethod() {
        assertEquals(2, CpuInfo.getCpuCount(SAMPLE_CPUINFO_OUTPUT));
    }
}
