package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

/* JADX INFO: loaded from: classes.dex */
public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzbgt;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zzpZ() == null || !dataHolder.zzpZ().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzbgt = null;
        } else {
            this.zzbgt = new zzd<>(dataHolder, PersonEntity.CREATOR);
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Person get(int position) {
        return this.zzbgt != null ? (Person) this.zzbgt.get(position) : new zzk(this.zzahi, position);
    }
}
